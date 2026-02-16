import React from 'react';
import { Provider } from 'react-redux';
import { store } from './store/store';
import { DndProvider } from 'react-dnd';
import { HTML5Backend } from 'react-dnd-html5-backend';
import Dashboard from './components/Dashboard';

function App() {
  return (
    <Provider store={store}>
      <DndProvider backend={HTML5Backend}>
        <Dashboard />
      </DndProvider>
    </Provider>
  );
}
export default App;

