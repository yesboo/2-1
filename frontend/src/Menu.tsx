
import { useLocation, useNavigate } from 'react-router-dom';

function Menu(){
    const location = useLocation();
    const navigate = useNavigate();
    const {name, acname} = location.state || {};
    return (
        <div style = {{ padding :"2rem"}} >
            <h2>Menu</h2>
            <p>ようこそ、{name}さん！</p>
            <ul>
                <li><button onClick={() => navigate('/hello')}>wildfly</button></li>
            </ul>
        </div> 
    );
}
export default Menu

