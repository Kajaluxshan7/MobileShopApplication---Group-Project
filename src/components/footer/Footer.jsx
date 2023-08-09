import React from "react";
import "./Footer.scss";
import { FaLocationArrow, FaMobileAlt, FaEnvelope } from "react-icons/fa";
import Payment from "../../assets/payments.png";
import { useNavigate } from "react-router-dom";

const Footer = () => {
    const navigate = useNavigate();
    return (
        <div className="footer">
            <div className="footer-content">
                <div className="col">
                    <div className="title">About</div>
                    <div className="text">
                        Place to buy your next smartphone for the 
                        lowest price in Srilanka.
                    </div>
                </div>
                <div className="col">
                    <div className="title">Contact</div>
                    <div className="c-item">
                        <FaLocationArrow className="arrowIcon" />
                        <div className="text">
                        Lucky Plaza,
                        70/06,
                        Ground Floor,
                        Colombo 03.
                        </div>
                    </div>
                    <div className="c-item">
                        <FaMobileAlt className="MobileAlt" />
                        <div className="text">Phone: 071 91 33 821</div>
                    </div>
                    <div className="c-item">
                        <FaEnvelope className="Envelope"/>
                        <div className="text">Email: rukvap222@gmail.com</div>
                    </div>
                </div>
                <div className="col">
                    <div className="title">Categories</div>
                    <span className="text" onClick={() => navigate(`/category/${"3"}`)}>APPLE</span>
                    <span className="text" onClick={() => navigate(`/category/${"1"}`)}>SAMSUNG</span>
                    <span className="text" onClick={() => navigate(`/category/${"2"}`)}>PIXEL BY GOOGLE</span>
                    <span className="text" onClick={() => navigate(`/category/${"4"}`)}>SONY</span>
                    
                </div>
                <div className="col">
                    <div className="title"  >Pages</div>
                    <span className="text" onClick={() => navigate("/")}>Home</span>
                    <span className="text" onClick={() => navigate("/about")}>About</span>
                    
                </div>
            </div>
            <div className="bottom-bar">
                <div className="bottom-bar-content">
                    <span className="text">
                       Phonez e- commerce store created by
                       Group 2.
                    </span>
                    <img src={Payment} />
                </div>
            </div>
        </div>
    );
};

export default Footer;
