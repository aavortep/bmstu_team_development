import React from 'react';
import '../../App.css';
import { useParams } from 'react-router';

function withParams(Component) {
    return props => <Component {...props} params={useParams()} />;
}

class AlbumInfoPage extends React.Component {
    album;
    works;
    constructor(props) {
        super(props);
        let xhr = new XMLHttpRequest();
        let { albumId } = this.props.params;
        xhr.open('GET', 'http://176.118.165.63:6670/albums/'+albumId, false);
        try {
          xhr.send();
          if (xhr.status !== 200) {
            alert(`Error ${xhr.status}: ${xhr.statusText}`);
          } else {
            this.album = JSON.parse(xhr.response);
            //alert(JSON.parse(this.album)["name"]);
          }
        } catch(err) {
          alert("Request failed");
        }
          xhr.open('GET', 'http://176.118.165.63:6670/albums/' + albumId + '/works', false);
          try {
            xhr.send();
            if (xhr.status !== 200) {
              alert(`Error ${xhr.status}: ${xhr.statusText}`);
            } else {
              this.works = xhr.response;
              //alert(JSON.parse(this.works)[0]["image"]["id"]);
            }
          } catch(err) {
            alert("Request failed " + err);
          }
    }

    render() {
        return (
            <div>
                <div className='Header-box'>
                    Artfolio
                </div>

                <div>
                    <a href='/home'>
                        <button type='button' className='Side-btn' style={{position: 'fixed', top: '97px', right: '0'}}>
                            Лента
                        </button>
                    </a>
                    <a href='/search'>
                        <button type='button' className='Side-btn' style={{position: 'fixed', top: '343px', right: '0'}}>
                            Поиск
                        </button>
                    </a>
                </div>

                <div className='Img-info'>
                    <p className='Center-img'><img className='Img-info__img' src={"data:image/jpg;base64," + 
                          JSON.parse(this.works)[0]["image"]["data"]} 
                          alt={this.album["name"]}></img></p>
                    <div className='Feed-item__title'>
                        {"Автор: " + this.album["creator"]["name"]}
                    </div>
                    <div className='Feed-item__title'>
                        {this.album["name"] + " (" + this.album["albumType"] + ")"}
                    </div>
                    <div className='Feed-item__title'>
                        {"ПО: " + this.album["software"]}
                    </div>
                </div>
            </div>
        )
    }
}

export default withParams(AlbumInfoPage);