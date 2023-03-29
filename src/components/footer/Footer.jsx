import React from "react";
import "./footer.css";
import logo1 from "./logo.jpg";
import { Link } from "react-router-dom";

const Footer = () => {
  return (
    <>
      <footer>
        <div className='containerGrid2'>
            
          <div className='box'>
          <div className="image">
            <img src={logo1} alt="" />
            </div>
          
        
            <div className='icon d_flex'>
            
             
            </div>
          </div>

          <div className='box12'>
            <h2>About Us</h2>
            <ul>
                <li> <Link>About Phonez</Link> </li>
                <li> <Link>Terms & Conditions</Link> </li>
                <li> <Link>Privacy Policy</Link> </li>
            </ul>
          </div>
          <div className='box'>
            <h2>Contact Us</h2>
            <ul>
              <li>70 Washington Square South, New York, NY 10012, United States </li>
              <li>Email: uilib.help@gmail.com</li>
              <li>Phone: +1 1123 456 780</li>
            </ul>
          </div>
        </div>
      </footer>
    </>
  )
}

export default Footer
