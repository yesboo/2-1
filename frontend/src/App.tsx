import { useState } from 'react'
import { createStaticHandler, useNavigate } from 'react-router-dom'

function App() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();
  //const [loggedInUser, setLoggedInUser] = useState<{acname : String; name : String} |null>(null);

  const login = async () => {
    debugger;
    try {
      const res = await fetch('http://localhost:8080/api/auth/login', {
        method: "POST", 
        headers: { "Content-Type" : "application/json",},
        body: JSON.stringify({ username, password, }),
      });
      console.log("response status=", res.status);

      const data = await res.json();

      console.log("data=", data);
      console.log("success=", data.success);
      console.log("acname=", data.acname);
      console.log("name=", data.name);

      if (data.success){
        console.log("navigate start");
        navigate('/menu', { state: { acname: data.acname, name: data.name } });
      } else {
        setError('ログインIDまたはパスワードが違います。');
        setPassword('');
      }
    } catch(e){
      console.error("login error", e);
    }
 };

  return (
    <div style={{ padding: "2rem"}}>
      <h2>Login</h2>
      <div>
        <input placeholder="username" value={username} onChange={(e)=> setUsername(e.target.value)} />
      </div>
      <div>
        <input type="password" placeholder = "password" value={password} onChange={(e)=> setPassword(e.target.value)} />
      </div>
      <button onClick={login}>Login</button>
      <p style ={{color: 'red' }} >{error}</p>
  </div>
  )
}

export default App
