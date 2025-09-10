export const ClaimService = {
  submitClaim: async (claim) => {
    return new Promise((resolve) => setTimeout(() => resolve(claim), 500));
  },
  getClaims: async () => {
    return new Promise((resolve) =>
      setTimeout(
        () =>
          resolve([
            { id: 1, customerName: "John Doe", claimType: "Health", claimAmount: 5000, status: "Pending", submissionDate: "2025-09-10" },
          ]),
        500
      )
    );
  },
};
