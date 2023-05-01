import React from 'react';
import '../../App.css';

class HomePage extends React.Component {
    render() {
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
        
              <div>
                <div id='pressed_btn' style={{position: 'fixed', top: '97px', right: '0'}}>
                  <p>Лента</p>
                </div>
                <a href='search'>
                  <button type='button' className='Side-btn' style={{position: 'fixed', top: '343px', right: '0'}}>
                    Поиск
                  </button>
                </a>
              </div>
        
              <link href="dist/smooth-scrollbar.css" rel="stylesheet"/>
              <script src="dist/smooth-scrollbar.js"></script>
              <section scrollbar>
                <div id = "feed_img" style={{float: 'left'}}>
                  <p style={{paddingTop: '190px', textAlign: 'left'}}>Иванов Иван</p>
                  <p>Альбом 1</p>
                </div>
                <div id = "feed_img" style={{marginLeft: '44px', float: 'left'}}>
                  <p style={{paddingTop: '190px', textAlign: 'left'}}>Иванов Иван</p>
                  <p>Альбом 2</p>
                </div>
                <div id = "feed_img" style={{marginLeft: '44px', float: 'left'}}>
                  <p style={{paddingTop: '190px', textAlign: 'left'}}>Иванов Иван</p>
                  <p>Альбом 3</p>
                </div>
                <div id = "feed_img" style={{marginTop: '64px', float: 'left'}}>
                  <p style={{paddingTop: '190px', textAlign: 'left'}}>Иванов Иван</p>
                  <p>Альбом 4</p>
                </div>
                <div id = "feed_img" style={{marginTop: '64px', marginLeft: '44px', float: 'left'}}>
                  <p style={{paddingTop: '190px', textAlign: 'left'}}>Иванов Иван</p>
                  <p>Альбом 5</p>
                </div>
                <div id = "feed_img" style={{marginTop: '64px', marginLeft: '44px', float: 'left'}}>
                  <p style={{paddingTop: '190px', textAlign: 'left'}}>Иванов Иван</p>
                  <p>Альбом 6</p>
                </div>
              </section>
            </div>
          );
    }
}

export default HomePage;