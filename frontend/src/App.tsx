import { useState } from 'react'


function App() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [result, setResult] = useState<String>('');

  const login = async () => {
    debugger;
    const res = await fetch('http://172.26.156.80:8080/api/hello', {
      method: "POST", 
      headers: { "Content-Type" : "application/json",},
      body: JSON.stringify({ username, password, }),
    });
    const data = await res.json();
    setResult(data.message);
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
      <p>{result}</p>
  </div>
  )
}

export default App
