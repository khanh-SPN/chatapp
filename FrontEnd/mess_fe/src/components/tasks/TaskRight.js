import { useEffect, useRef, useState } from "react";
import UpdateScroll from "../transaction/UpdateScroll"
function TaskRight(myFriendId) {
    
    const [status,setStatus] = useState(1);
    const [showMenu, setShowMenu] = useState(false);
    const [conversations, setConversations] = useState([]);
    const [friendId,setFriendId] = useState(myFriendId.messageByFriend.id);
    const scrollRef = useRef();
  
    useEffect(()=>{
        scrollRef.current.scrollTop = scrollRef.current.scrollHeight;
    },[conversations])
   
 
    useEffect(()=> {
        
    const IntervalId = setInterval(()=>{setStatus(preve => preve +1);
    },1000);
        return(()=>{
            window.clearInterval(IntervalId);
        })
    },[])

    useEffect(()=>{
        setFriendId(myFriendId.messageByFriend.id);
        setStatus(prive => myFriendId.messageByFriend.id);
    },[myFriendId])

    useEffect(()=>{
        
        fetch(`http://localhost:8080//api/message/${myFriendId.loginInfomation.id}/${friendId}`)
            .then(response => response.json())
            .then(items => {
                console.log(items);
                if(items.length !== conversations.length) {
                    setConversations(items);
                }
               
            })
    },[status])

   
    const [newMessage, setMessage] = useState('');
    const sendMessage = () => {
      
           
        
        setMessage(prev => '');
        
        fetch(`http://localhost:8080//api/annex-message/${myFriendId.loginInfomation.id}/${friendId}/${newMessage}`)
         
    }
   
    return (
        <div className="col-md-8 col-xl-6 chat">
            <div className="card">
                <div className="card-header msg_head">
                    <div className="d-flex bd-highlight">
                        <div className="img_cont">
                            <img src = {`./img/${myFriendId.messageByFriend.image}`} className="rounded-circle user_img" />
                            <span className= {myFriendId.messageByFriend.status === "ONLINE" ? "online_icon" : "online_icon offline"} />
                        </div>
                        <div className="user_info">
                            <span>{myFriendId.messageByFriend.fullName}</span>
                            <p>{conversations.length} tin nhắn</p>
                        </div>
                        <div className="video_cam">
                            <span><i className="fas fa-video" /></span>
                            <span><i className="fas fa-phone" /></span>
                        </div>
                    </div>
                    <span id="action_menu_btn"><i className="fas fa-ellipsis-v" onClick={() => setShowMenu(!showMenu)} /></span>
                    {
                        showMenu &&
                        <div className="action_menu">
                            <ul>
                                <li><i className="fas fa-user-circle" />Xem trang cá nhân</li>
                                <li><i className="fas fa-plus" /> Tạo nhóm</li>
                                <li><i className="fas fa-ban" /> Chặn tin nhắn</li>
                            </ul>
                        </div>

                    }


                </div>
                <div ref={scrollRef} id="scroll_id" className="card-body msg_card_body">


                    {
                    conversations.map((conversation, index) => (
                        <div key={conversation.id}
                        className={conversation.from !== myFriendId.loginInfomation.fullName ?
                         "d-flex justify-content-start mb-4" :
                         "d-flex justify-content-end mb-4"
                        }>
                            <div className="img_cont_msg">
                                <img src={`./img/${conversation.image}`} className="rounded-circle user_img_msg" />
                            </div>
                            <div className="msg_cotainer">
                               {conversation.content}
                                <span className="msg_time">
                                    {conversation.timeSend}
                                </span>
                            </div>
                        </div>
                    )
                    )}



                </div>
                <div className="card-footer">
                    <div className="input-group">
                        <div className="input-group-append">
                            <span className="input-group-text attach_btn"><i className="fas fa-paperclip" /></span>
                        </div>
                        <textarea className="form-control type_msg" onChange={(e)=> setMessage(e.target.value)} value={newMessage}/>
                        <div className="input-group-append">
                            <span className="input-group-text send_btn"><i className="fas fa-location-arrow" onClick={sendMessage}/></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default TaskRight