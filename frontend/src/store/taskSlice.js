import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

export const fetchBoards = createAsyncThunk('tasks/fetchBoards', async (_, { getState }) => {
  const token = getState().auth.token;  // Assume auth slice
  const res = await axios.get('/api/boards', { headers: { Authorization: `Bearer ${token}` } });
  return res.data;
});

const taskSlice = createSlice({
  name: 'tasks',
  initialState: { boards: [], loading: false },
  reducers: {
    moveTask: (state, action) => {
      const { taskId, newListId, position } = action.payload;
      const task = state.tasks.find(t => t.id === taskId);
      if (task) { task.listId = newListId; task.position = position; }
    }
  },
  extraReducers: (builder) => builder.addCase(fetchBoards.fulfilled, (state, action) => { state.boards = action.payload; })
});
export const { moveTask } = taskSlice.actions;
export default taskSlice.reducer;

