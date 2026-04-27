import {Routes, Route} from 'react-router-dom'
import App from './App'
import Menu from './Menu'
import Hello from './Hello'

function AppRoutes(){
    return(
        <Routes>
            <Route path="/" element={<App />}/>
            <Route path="/menu" element={<Menu />}/>
            <Route path="/hello" element={<Hello />}/>
        </Routes>
    )
}

export default AppRoutes
