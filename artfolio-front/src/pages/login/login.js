import React from 'react';
import '../../App.css';
import { Link } from "react-router-dom";

class LoginPage extends React.Component {
    async sendLogInData(data) {
        return await fetch('http://176.118.165.63:6670/users/login', {
            method: 'POST',
            body: data,
        })
    }

    async handleLogInForm(event) {
        event.preventDefault()
        const data = new FormData(event.target)
        const response = await this.sendLogInData(data)
        if (response.status === 200) {
            const body = await response.json()
            alert("Успешная Регистрация:\nТокен:" + body["token"])
        }
        else alert(response.status)
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

                <form action="" id="register">
                    <center>
                        <input type="text" id="name" name="fio" placeholder="ФИО" className="Text-input"/>
                    </center>
                    <center>
                        <input type="email" id="email" name="mail" placeholder="Email" className="Text-input"/>
                    </center>
                    <center>
                        <input type="password" id="pass" name="password" placeholder="Пароль" className="Text-input"/>
                    </center>
                    <center>
                        <input type="password" id="pass" name="password" placeholder="Подтвердите пароль" 
                        className="Text-input"/>
                    </center>
                    <center>
                        <Link to='/feed'>
                            <button type="submit" className="Btn" onSubmit={this.handleLogInForm}>
                                Зарегистрироваться
                            </button>
                        </Link>
                    </center>
                </form>
                <center>
                    <a href="/signin" className="Label-font">
                        У меня уже есть аккаунт
                    </a>
                </center>
            </div>
        )
    }
}

export default LoginPage;