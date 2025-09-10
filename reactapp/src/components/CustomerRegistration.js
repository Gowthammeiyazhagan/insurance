import React, { useState } from "react";
import "./CustomerRegistration.css";

const CustomerRegistration = () => {
  const [form, setForm] = useState({
    name: "",
    email: "",
    phoneNumber: "",
    policyNumber: "",
  });
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const validate = () => {
    if (!form.name || !form.email || !form.phoneNumber || !form.policyNumber) {
      return "All fields are required";
    }
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(form.email)) {
      return "Invalid email format";
    }
    return null;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const errorMessage = validate();
    if (errorMessage) {
      setError(errorMessage);
      return;
    }
    setError(""); // clear error if valid
    console.log("Customer registered:", form);
  };

  return (
    <div className="form-container">
      <h2>Register New Customer</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Name
          <input
            type="text"
            name="name"
            value={form.name}
            onChange={handleChange}
          />
        </label>
        <label>
          Email
          <input
            type="email"
            name="email"
            value={form.email}
            onChange={handleChange}
          />
        </label>
        <label>
          Phone Number
          <input
            type="text"
            name="phoneNumber"
            value={form.phoneNumber}
            onChange={handleChange}
          />
        </label>
        <label>
          Policy Number
          <input
            type="text"
            name="policyNumber"
            value={form.policyNumber}
            onChange={handleChange}
          />
        </label>
        <button type="submit" className="btn-primary">
          Register
        </button>
      </form>

      {error && (
        <p data-testid="error-message" className="error">
          {error}
        </p>
      )}
    </div>
  );
};

export default CustomerRegistration;
