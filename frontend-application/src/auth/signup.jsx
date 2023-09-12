import React from 'react'
import Signin from './signin';
import './auth.scss'

export default function Signup() {
  return (
    <div className='container'>
        <div className='form-container'>
            <div className="main">
                <input type="checkbox" id="check" aria-hidden="true" />

            <div className="signup">
                <form>
                    <label htmlFor="check" aria-hidden="true">
                        Sign up
                    </label>
                    <input type="text" name="fname" placeholder="First Name" required />
                    <input type="text" name="lname" placeholder="Last Name" required />
                    <input type="number" name="mobile" placeholder="Mobile No" required />
                    <input type="email" name="email" placeholder="Email" required />
                    <input type="password" name="pswd" placeholder="Password" required />
                    <button type="submit">Sign up</button>
                </form>
            </div>

      <Signin/>
      </div>


       </div>

    </div>
  );
}
