import React, { useState } from 'react';
import './App.css';

function App() {
  const [tasks, setTasks] = useState({
    todo: [{ id: 1, title: "Task 1 ✅" }, { id: 2, title: "Task 3 📝" }],
    progress: [{ id: 3, title: "Task 2 ⏳" }],
    done: []
  });

  const onDragStart = (e, taskId, sourceList) => {
    e.dataTransfer.setData('taskId', taskId.toString());
    e.dataTransfer.setData('sourceList', sourceList);
  };

  const onDragOver = (e) => {
    e.preventDefault();
  };

  const onDrop = (e, targetList) => {
    const taskId = parseInt(e.dataTransfer.getData('taskId'));
    const sourceList = e.dataTransfer.getData('sourceList');
    
    const newTasks = { ...tasks };
    const task = newTasks[sourceList].find(t => t.id === taskId);
    
    if (!task) return; // Safety check
    
    newTasks[sourceList] = newTasks[sourceList].filter(t => t.id !== taskId);
    newTasks[targetList].push(task);
    
    setTasks(newTasks);
  };

  const renderTasks = (listName) => (
    tasks[listName]?.map(task => (
      <div
        key={task.id}
        className="task"
        draggable
        onDragStart={(e) => onDragStart(e, task.id, listName)}
      >
        {task.title}
      </div>
    )) || null
  );

  return (
    <div className="App">
      <header className="App-header">
        <h1>🚀 Task Collaboration Platform</h1>
        <p>Drag tasks between columns! Backend: localhost:8080</p>
      </header>

      <div className="kanban-board">
        <div className="lists-container">
          <div className="list" onDragOver={onDragOver} onDrop={(e) => onDrop(e, 'todo')}>
            <h3>📋 To Do ({tasks.todo?.length || 0})</h3>
            {renderTasks('todo')}
          </div>

          <div className="list" onDragOver={onDragOver} onDrop={(e) => onDrop(e, 'progress')}>
            <h3>⚙️ In Progress ({tasks.progress?.length || 0})</h3>
            {renderTasks('progress')}
          </div>

          <div className="list" onDragOver={onDragOver} onDrop={(e) => onDrop(e, 'done')}>
            <h3>✅ Done ({tasks.done?.length || 0})</h3>
            {renderTasks('done')}
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;

