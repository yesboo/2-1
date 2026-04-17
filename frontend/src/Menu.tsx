
import { useLocation } from 'react-router-dom';

function Menu(){
    const location = useLocation();
    const {name, acname} = location.state || {};
    return (
        <div style = {{ padding :"2rem"}} >
            <h2>Menu</h2>
            <p>ようこそ、{name}さん！</p>
        </div> 
    );
}
export default Menu

