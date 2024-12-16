import { useEffect, useState } from "react";


function TaskLeft(showTaskRight) {
    const clickMe = (friend) => {
        showTaskRight.showTaskRight(friend);
    }

    const [friend, setFriend] = useState([]);
    const [updatePage, setUpdatepage] = useState(1);
    const [fillting, setFillting] = useState(false);
    const [showManagerAccount, setShowManagerAccount] = useState(false);

    useEffect(() => {

        const IntervalId = setInterval(() => {
            setUpdatepage(preve => preve + 1);
        }, 2000);
        return (() => {
            window.clearInterval(IntervalId);
        })
    }, [])


    useEffect(() => {
        fetch(`http://localhost:8080//api/my-friend/${showTaskRight.loginInfomation.id}`)
            .then(response => response.json())
            .then(items => {

                if (!(JSON.stringify(friend) == JSON.stringify(items)) && fillting === false) {
                    setFriend(items);
                }

            })
    }, [updatePage])

    const fillterName = (e) => {
        if (e.target.value) {
            let task = friend.filter((fr) => {
                return fr.fullName.toLowerCase().indexOf(e.target.value.toLowerCase()) !== -1;
            })
            setFriend(task);
            setFillting(true);
        } else {
            setUpdatepage(prev => prev + 1);
            setFillting(false);
        }

    }

    return (
        <div className="col-md-4 col-xl-3 chat"><div className="card mb-sm-3 mb-md-0 contacts_card">
            <div className="card-header">
                <ul className="contacts">
                    <li >
                        <div className="d-flex bd-highlight">
                            <div className="img_cont" >
                                <img  src={`./img/${showTaskRight.loginInfomation.image}`} className="rounded-circle user_img hover_avartar" onClick={()=>setShowManagerAccount(!showManagerAccount)}/>
                            </div>
                        </div>
                    </li>
                </ul>
                {
                    showManagerAccount &&
                    <div className="action_menu2">
                            <ul>
                                <li><i className="fas fa-user-circle" />Cài đặt tài khoản</li>
                                <li onClick={showTaskRight.logOut}><i className="fas fa-sign-out-alt" /> Đăng xuất</li>
                            </ul>
                    </div>
                }
                
                <div className="input-group">
                    <input type="text" placeholder="Tìm kiếm" className="form-control search" onChange={fillterName} />
                    <div className="input-group-prepend">
                        <span className="input-group-text search_btn"></span>
                    </div>
                </div>
            </div>
            <div className="card-body contacts_body">
                <ul className="contacts">
                    {friend.map(fr =>
                        <li key={fr.id}>
                            <div className="d-flex bd-highlight">
                                <div className="img_cont" >
                                    <img src={`./img/${fr.image}`} className="rounded-circle user_img" />
                                    <span className={fr.status === "ONLINE" ? "online_icon" : "online_icon offline"} />
                                </div>
                                <div className="user_info">
                                    <span onClick={() => clickMe({
                                        id: fr.id,
                                        fullName: fr.fullName,
                                        image: fr.image,
                                        status: fr.status
                                    })} className="name-hover">{fr.fullName}</span>
                                    {fr.status === "OFLINE" && <p>Online 50 phút trước</p>}

                                </div>
                            </div>
                        </li>
                    )}

                </ul>
            </div>
            <div className="card-footer" />
        </div>
        </div>
    )
}
export default TaskLeft