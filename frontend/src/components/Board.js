import React, { useEffect, useState } from 'react';
import SearchBar from './SearchBar';
import { useDispatch, useSelector } from 'react-redux';
import { fetchBoards } from '../store/taskSlice';

const Board = ({ boardId }) => {
  const dispatch = useDispatch();
  const { boards } = useSelector(state => state.tasks);
  const [searchQuery, setSearchQuery] = useState('');

  // Search handler for debounced search
  const handleSearch = (query) => {
    setSearchQuery(query);
    // This triggers API call with ?search=query param
    dispatch(fetchBoards({ boardId, search: query }));
  };

  useEffect(() => {
    dispatch(fetchBoards({ boardId }));
  }, [dispatch, boardId]);

  const filteredTasks = boards.find(b => b.id === boardId)?.tasks || [];

  return (
    <div className="board">
      <h3>Board: {boards.find(b => b.id === boardId)?.name}</h3>
      
      {/* ⭐ SEARCH WITH DEBOUNCE ⭐ */}
      <SearchBar onSearch={handleSearch} placeholder="Search tasks by title..." />
      
      <div className="lists-container" style={{ display: 'flex', gap: '1rem' }}>
        {/* Render lists and tasks */}
        {filteredTasks.map(task => (
          <div key={task.id} className="task-item">{task.title}</div>
        ))}
      </div>
    </div>
  );
};

export default Board;

