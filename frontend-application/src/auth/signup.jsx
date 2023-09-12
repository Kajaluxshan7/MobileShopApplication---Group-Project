import React, { useState } from 'react';
import axios from 'axios';
import Signin from './signin';
import './auth.scss'

export default function Signup() {
  const [formData, setFormData] = useState({
    firstname: '',
    lastname: '',
    mobile_no: '',
    email: '',
    password: '',
    user_role: 'user', // Default to 'user' role
  });


  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };


  const handleSubmit = async (e) => {
    e.preventDefault();

    try {

      const response = await axios.post('http://localhost:8080/auth/register', formData);
      console.log('Registration Successful', response.data);

      // Clear the form after successful registration
      setFormData({
        firstname: '',
        lastname: '',
        mobile_no: '',
        email: '',
        password: '',
        user_role: 'user',
      });
    } catch (error) {
      console.error('Registration Failed', error);
    }
  };

  return (
    <div className="container">
      <div className="form-container">
        <div className="main">
          <input type="checkbox" id="check" aria-hidden="true" />

          <div className="signup">
            <form onSubmit={handleSubmit}>
              <label htmlFor="check" aria-hidden="true">
                Sign up
              </label>
              
              <input
                type="text"
                name="firstname"
                placeholder="First Name"
                value={formData.firstname}
                onChange={handleInputChange}
                required
              />

              <input
                type="text"
                name="lastname"
                placeholder="Last Name"
                value={formData.lastname}
                onChange={handleInputChange}
                required
              />

              <input
                type="number"
                name="mobile_no"
                placeholder="Mobile No"
                value={formData.mobile_no}
                onChange={handleInputChange}
                required
              />

              <input
                type="email"
                name="email"
                placeholder="Email"
                value={formData.email}
                onChange={handleInputChange}
                required
              />
              
              <input
                type="password"
                name="password"
                placeholder="Password"
                value={formData.password}
                onChange={handleInputChange}
                required
              />
              {/* Add a select input to choose user or admin */}
              <select
                name="user_role"
                value={formData.user_role}
                onChange={handleInputChange}
              >
                <option value="user">User</option>
                <option value="admin">Admin</option>
              </select>
              <button type="submit">Sign up</button>
            </form>
          </div>

          <Signin />
        </div>
      </div>
    </div>
  );
}
