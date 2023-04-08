import React from 'react';
import { useContext, useState } from "react";

import { useParams } from "react-router-dom";

import { useNavigate } from "react-router-dom";


const Login = () => {

    const navigate = useNavigate();
    return (

        <div className='d-flex justify-content'>
            <div className='bg-wh'>
                <form action=''>
                    <div className='mb-3'>
                        <label htmlFor='email'>Email</label>
                        <input type="email" placeholder='Enter email'/>
                    </div>

                    <div className='mb-3'>
                        <label htmlFor="password">Password</label>
                        <input type="password" placeholder='Enter Password'/>
                    </div>

                    <button className='btn btn-success'>Log in</button>
                    <p>fvkjfvnfjfvnfjkvfnvb fjfbfgjfn</p>
                    <button className='btn btn-default border'>Create Account</button>
                </form>
            </div>

        </div>
    )

}

export default Login;