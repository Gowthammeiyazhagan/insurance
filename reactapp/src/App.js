import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import CustomerRegistration from "./components/CustomerRegistration";
import ClaimSubmission from "./components/ClaimSubmission";
import ClaimList from "./components/ClaimList";
import "./App.css";

function App() {
  return (
    <Router>
      <div>
        <nav className="main-nav">
          <Link to="/">Home</Link>
          <Link to="/customers">Customers</Link>
          <Link to="/register">New Customer</Link>
          <Link to="/claims">Claims</Link>
          <Link to="/submit-claim">Submit Claim</Link>
        </nav>

        <div className="app-content">
          <Routes>
            <Route
              path="/"
              element={
                <div>
                  <h1>Insurance Claim Processing System</h1>
                  <p>Use the menu above to manage customers and claims.</p>
                </div>
              }
            />
            <Route path="/customers" element={<div><h2>Customers Page</h2></div>} />
            <Route path="/register" element={<CustomerRegistration />} />
            <Route path="/claims" element={<ClaimList />} />
            <Route path="/submit-claim" element={<ClaimSubmission />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;
