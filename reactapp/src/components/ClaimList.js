import React, { useState, useEffect } from "react";
import "./ClaimList.css";

const ClaimList = () => {
  const [claims, setClaims] = useState([]);
  const [filter, setFilter] = useState("All");

  useEffect(() => {
    // Dummy data for now
    setClaims([
      { id: 1, customerName: "John Doe", claimType: "Health", claimAmount: 5000, status: "Pending", submissionDate: "2025-09-10" },
      { id: 2, customerName: "Jane Smith", claimType: "Car", claimAmount: 15000, status: "Approved", submissionDate: "2025-09-08" },
    ]);
  }, []);

  const filteredClaims = claims.filter(
    (claim) => filter === "All" || claim.status === filter
  );

  return (
    <div className="list-container">
      <h2>Claims List</h2>
      <label>Filter by Status:</label>
      <select value={filter} onChange={(e) => setFilter(e.target.value)}>
        <option value="All">All</option>
        <option value="Pending">Pending</option>
        <option value="Approved">Approved</option>
        <option value="Rejected">Rejected</option>
      </select>

      <table>
        <thead>
          <tr>
            <th>Claim ID</th>
            <th>Customer Name</th>
            <th>Claim Type</th>
            <th>Amount</th>
            <th>Status</th>
            <th>Submission Date</th>
          </tr>
        </thead>
        <tbody>
          {filteredClaims.map((claim) => (
            <tr key={claim.id}>
              <td>{claim.id}</td>
              <td>{claim.customerName}</td>
              <td>{claim.claimType}</td>
              <td>{claim.claimAmount}</td>
              <td>{claim.status}</td>
              <td>{claim.submissionDate}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ClaimList;
