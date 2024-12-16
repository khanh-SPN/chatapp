import logo from './logo.svg';
import './App.css';
import TaskLeft from './components/tasks/TaskLeft'
import TaskRight from './components/tasks/TaskRight'
import { useEffect, useState } from 'react';

let myFriendId;

function App() {


    const [taskRight, setTaskRight] = useState(false);

    const [friendMessage, setFriendMessage] = useState();

    const [email, setEmail] = useState('');

    const [password, setPassword] = useState('');

    const [loginInfomation, setLoginInfomation] = useState();

    const showTaskRight = (friend) => {
        myFriendId = friend;
        setFriendMessage(prev => myFriendId);

    }

    useEffect(()=> {
        const loginInfo = localStorage.getItem("login");
        
        if(loginInfo) {
            setLoginInfomation(JSON.parse(loginInfo));
        } else {
           
        }
    },[]);

    useEffect(()=> {
       if(loginInfomation) {
        console.log('khi log gin ', loginInfomation.id);
       } else {
        
       }
      
    },[loginInfomation])
    
    const logOut = () => {
        console.log('khi log out ' , loginInfomation.id);
        fetch(`http://localhost:8080//api/logout/${loginInfomation.id}`)
        setLoginInfomation();
        localStorage.removeItem("login");
    }

    const login = () => {
        if(email === '' || password === '') {
            console.log("vui lòng nhập");
        } else {
            console.log('email ', email);
            console.log('password ', password)
            fetch(`http://localhost:8080//api/login/${email}/${password}`)
            .then(response => response.json())
            .then(items => {
                if(items.fullName) {
                    setLoginInfomation(items);
                    localStorage.setItem("login", JSON.stringify(items));
                }
                
            })
        }
    }

    useEffect(() => {

        if (myFriendId) {
            setTaskRight(prev => true);
        }

    }, [friendMessage]);


    return (
        <div>



            <div className="container-fluid h-100 mt30">
                <div className="row justify-content-center h-100">
                    {
                        loginInfomation && <TaskLeft 
                        showTaskRight={showTaskRight}
                        loginInfomation = {loginInfomation}
                        logOut = {logOut}
                        />
                    }

                    {
                        loginInfomation && taskRight === true && <TaskRight 
                        messageByFriend={friendMessage}
                        loginInfomation = {loginInfomation}
                        
                        />
                    }

                    {
                        typeof loginInfomation === "undefined" && (
                            <div id="login" className="col-md-4 col-xl-3 chat">
                                <div className="card2 mb-sm-3 contacts_card">
                                    <div className="card-header">
                                  
                                        <div className="input-group">
                                            <input type="text" placeholder="Email" className="form-control search" onChange={(e)=>setEmail(e.target.value)}/>
                                            <div className="input-group-prepend">
                                                <span className="input-group-text search_btn"></span>
                                            </div>

                                        </div>
                                        <br></br>
                                        <div className="input-group">
                                            <input type="password" placeholder="Mật khẩu" className="form-control search" onChange={(e)=>setPassword(e.target.value)}/>
                                            <div className="input-group-prepend">
                                                <span className="input-group-text search_btn"></span>
                                            </div>
                                        </div>

                                        <br></br>
                                        <div className="input-group">
                                            <button className="form-control search backgroud-button" onClick={login}>Đăng nhập</button>
                                            <div className="input-group-prepend">
                                                <span className="input-group-text search_btn backgroud-button"></span>
                                            </div>

                                        </div>
                                    </div>


                                </div>
                            </div>
                        )
                    }

                </div>
            </div>
        </div>
    );
}

export default App;
