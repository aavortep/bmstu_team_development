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

      <link href="dist/smooth-scrollbar.css" rel="stylesheet"/>
      <script src="dist/smooth-scrollbar.js"></script>
      <section scrollbar>
        <div id = "feed_img" style={{float: 'left'}}><p>Альбом 1</p></div>
        <div id = "feed_img" style={{marginLeft: '44px', float: 'left'}}><p>Альбом 2</p></div>
        <div id = "feed_img" style={{marginLeft: '44px', float: 'left'}}><p>Альбом 3</p></div>
        <div id = "feed_img" style={{marginTop: '44px', float: 'left'}}><p>Альбом 4</p></div>
        <div id = "feed_img" style={{marginTop: '44px', marginLeft: '44px', float: 'left'}}><p>Альбом 5</p></div>
        <div id = "feed_img" style={{marginTop: '44px', marginLeft: '44px', float: 'left'}}><p>Альбом 6</p></div>
      </section>
    </div>
  );
}

export default App;
