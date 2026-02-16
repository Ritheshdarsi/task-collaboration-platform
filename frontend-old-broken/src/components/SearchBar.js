import React, { useState, useEffect, useCallback } from 'react';
import { useDispatch } from 'react-redux';
import { debounce } from 'lodash'; // npm install lodash

const SearchBar = ({ onSearch, placeholder = "Search tasks..." }) => {
  const [searchTerm, setSearchTerm] = useState('');
  const dispatch = useDispatch();

  // Debounced search function (waits 300ms after typing stops)
  const debouncedSearch = useCallback(
    debounce((value) => {
      onSearch(value); // Call parent search handler
    }, 300),
    []
  );

  const handleChange = (e) => {
    const value = e.target.value;
    setSearchTerm(value);
    debouncedSearch(value);
  };

  return (
    <div className="search-container" style={{ marginBottom: '1rem' }}>
      <input
        type="text"
        className="form-control search-input"
        placeholder={placeholder}
        value={searchTerm}
        onChange={handleChange}
        style={{ padding: '0.75rem 1rem', fontSize: '1rem' }}
      />
      {searchTerm && (
        <button
          type="button"
          className="btn btn-outline-secondary clear-btn"
          onClick={() => {
            setSearchTerm('');
            onSearch('');
          }}
          style={{ marginLeft: '0.5rem' }}
        >
          Clear
        </button>
      )}
    </div>
  );
};

export default SearchBar;

