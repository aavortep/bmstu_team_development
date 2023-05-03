import React from 'react';
import '../../App.css';
import { Link } from "react-router-dom";

class SigninPage extends React.Component {
    async handleLogInForm(event) {
        //event.preventDefault()
        //const data = new FormData(event.target)
        //const response = await this.sendLogInData(data)
        //if (response.status === 200) {
        //    const body = await response.json()
        //    alert("Успешная регистрация:\nТокен:" + body["token"])
        //}
        //else alert(response.status)
    }

    render() {
        return (
            <div>
                <div className='Header-box'>
                    Artfolio
                </div>

                <div>
                    <a href='home'>
                        <button type='button' className='Side-btn' style={{position: 'fixed', top: '97px', right: '0'}}>
                            Лента
                        </button>
                    </a>
                    <a href='search'>
                        <button type='button' className='Side-btn' style={{position: 'fixed', top: '343px', right: '0'}}>
                            Поиск
                        </button>
                    </a>
                </div>

                <form action="" id="sign_in">
                    <center>
                        <input type="email" id="email" name="mail" placeholder="Email" className="Text-input"/>
                    </center>
                    <center>
                        <input type="password" id="pass" name="password" placeholder="Пароль" className="Text-input"/>
                    </center>
                    <center>
                        <Link to='/feed'>
                            <button type="submit" className="Btn" onSubmit={this.handleLogInForm}>
                                Войти
                            </button>
                        </Link>
                    </center>
                </form>
                <center>
                    <a href="/login" className="Label-font">
                        Зарегистрироваться
                    </a>
                </center>
            </div>
        )
    }
}

export default SigninPage;