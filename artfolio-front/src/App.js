//import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div>
      <div className='Header-box'>
        Artfolio
        <div id='links' style={{position: 'fixed', right: '15px', top: '5px'}}>
          <a href='login'>
            Зарегистрироваться
          </a>
        </div>
        <div id='links' style={{position: 'fixed', right: '15px', top: '35px'}}>
          <a href='signin'>
            Войти
          </a>
        </div>
      </div>
    </div>
  );
}

export default App;
