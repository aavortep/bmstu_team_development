//import logo from './logo.svg';
import './App.css';
import { Route, Routes, Navigate, BrowserRouter as Router } from 'react-router-dom';
import HomePage from './pages/home/home.js';
import LoginPage from './pages/login/login.js';
import SigninPage from './pages/signin/signin.js';
import SearchPage from './pages/search/search.js';
import FeedPage from './pages/feed/feed.js';

function App() {
  return (
    <div>
      <main>
        <Router>
          <Routes>
            <Route path='/home' element={<HomePage/>} />
            <Route path='/login' element={<LoginPage/>} />
            <Route path='/signin' element={<SigninPage/>} />
            <Route path='/search' element={<SearchPage/>} />
            <Route path='/feed' element={<FeedPage/>} />
            <Route exact path='/' element={<Navigate replace to='/home' />} />
          </Routes>
        </Router>
      </main>
    </div>
  );
}

export default App;
