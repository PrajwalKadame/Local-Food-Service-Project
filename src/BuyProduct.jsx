import React, { useEffect, useState } from 'react'
import axiosInstance from './helpers/axiosInstance'
import { useNavigate } from 'react-router-dom'

const BuyProduct = () => {

    let [userData,setUserData]=useState([])

    let navigate=useNavigate()

    useEffect(()=>{
        let fetchData=async()=>{
            let {data}=await axiosInstance.get("/posts")
            setUserData(data)

        }
        fetchData()
    },[])

  return (
    <>
    <h1>Royal Hermitage</h1>
    <h1>PRODUCTS</h1>
    {userData.map((x)=>{
        return(
            <>
            <h3>{`ProductName:${x.product}`}</h3>
            <h3>{`ProductQuantity:${x.pQty}`}</h3>
            <h3>{`ProductPrice:${x.price}`}</h3>
            <button onClick={()=>{
                navigate(`/UserOrder/${x.id}`)
            }}>BUY</button>
            </>
        )
    })}
    </>

  )
}

export default BuyProduct