import React from 'react'
import AddProduct from './AddProduct'
import {BrowserRouter as Router,Routes,Route} from "react-router-dom"
import AdminUpdate from './AdminUpdate'
import BuyProduct from './BuyProduct'
import UserOrder from './UserOrder'

const App = () => {
  return (
   <Router>
    <Routes>
        <Route path="/Admin" element={<AddProduct/>}></Route>
        <Route path="/AdminUpdate/:id" element={<AdminUpdate/>}></Route>
        <Route path="/" element={<BuyProduct/>}></Route>
        <Route path="/UserOrder/:id" element={<UserOrder/>}></Route>

    </Routes>
   </Router>
  )
}

export default App