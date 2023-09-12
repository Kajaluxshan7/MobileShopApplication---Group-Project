import React from 'react'
import './auth.scss'

export default function Signin() {
  return (
    <div className="login">
        <form>
          <label htmlFor="check" aria-hidden="true">
            Login
          </label>
          <input type="email" name="email" placeholder="Email" required />
          <input type="password" name="pswd" placeholder="Password" required />
          <button type="submit">Login</button>
        </form>
      </div>
  )
}
