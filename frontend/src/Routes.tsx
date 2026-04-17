import {Routes, Route} from 'react-router-dom'
import App from './App'
import Menu from './Menu'

function AppRoutes(){
    return(
        <Routes>
            <Route path="/" element={<App />}/>
            <Route path="/menu" element={<Menu />}/>
        </Routes>
    )
}

export default AppRoutes
