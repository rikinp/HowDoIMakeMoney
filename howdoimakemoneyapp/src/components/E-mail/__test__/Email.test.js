import React from "react";
import { render } from "@testing-library/react";
import Email from "../Email";

describe("Email component", () => {
  it("renders the selected email information", () => {
    const selectedEmail = {
      email: "example@example.com",
      subject: "Test email",
      message: "This is a test email",
    };

    const { getByText } = render(<Email selectedEmail={selectedEmail} />);

    expect(getByText(`From: ${selectedEmail.email}`)).toBeInTheDocument();
    expect(getByText(`Subject: ${selectedEmail.subject}`)).toBeInTheDocument();
    expect(getByText(selectedEmail.message)).toBeInTheDocument();
  });

  it("renders a message when no email is selected", () => {
    const { getByText } = render(<Email selectedEmail={null} />);
    expect(getByText("No email selected.")).toBeInTheDocument();
  });

});
