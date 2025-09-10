import React, { useState } from "react";
import "./ClaimSubmission.css";

const ClaimSubmission = () => {
  const [form, setForm] = useState({
    customerId: "",
    claimType: "",
    claimAmount: "",
    incidentDate: "",
    description: "",
  });
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const validate = () => {
    for (let key in form) {
      if (!form[key]) return "All fields are required";
    }
    if (Number(form.claimAmount) <= 0) {
      return "Claim amount must be positive";
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
    setError("");
    console.log("Claim submitted:", form);
  };

  return (
    <div className="form-container">
      <h2>Submit Claim</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Customer ID
          <input name="customerId" value={form.customerId} onChange={handleChange} />
        </label>
        <label>
          Claim Type
          <input name="claimType" value={form.claimType} onChange={handleChange} />
        </label>
        <label>
          Claim Amount
          <input name="claimAmount" value={form.claimAmount} onChange={handleChange} />
        </label>
        <label>
          Incident Date
          <input type="date" name="incidentDate" value={form.incidentDate} onChange={handleChange} />
        </label>
        <label>
          Description
          <textarea name="description" value={form.description} onChange={handleChange}></textarea>
        </label>
        <button type="submit" className="btn-primary">Submit</button>
      </form>
      {error && <p className="error">[Error - You need to specify the message]</p>}
    </div>
  );
};

export default ClaimSubmission;
