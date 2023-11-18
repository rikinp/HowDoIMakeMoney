import { render, screen, fireEvent, getByTestId } from "@testing-library/react";
import Email from "../../E-mail/Email";
import PermanentDrawerLeft from "../EmailInbox";

describe("PermanentDrawerLeft component", () => {
  const emailData = [
    {
      id: 1,
      subject: "Test email 1",
      email: "test1@test.com",
      message: "This is a test email 1",
      seen: true,
    },
    {
      id: 2,
      subject: "Test email 2",
      email: "test2@test.com",
      message: "This is a test email 2",
      seen: false,
    },
  ];

  it("renders the search input field", () => {
    render(<PermanentDrawerLeft emailData={emailData} />);
    const searchInput = screen.getByPlaceholderText("From: Search here...");
    expect(searchInput).toBeInTheDocument();
  });

  it("filters emails based on the search input field", () => {
    render(<PermanentDrawerLeft emailData={emailData} />);
    const searchInput = screen.getByPlaceholderText("From: Search here...");
    fireEvent.change(searchInput, { target: { value: "test1" } });
    const emailSubject = screen.getByText("Test email 1");
    expect(emailSubject).toBeInTheDocument();
    const email2Subject = screen.queryByText("Test email 2");
    expect(email2Subject).toBeNull();
  });
});

describe("PermanentDrawerLeft", () => {
  const emailData = [
    {
      id: 1,
      subject: "Test email 1",
      email: "test1@example.com",
      message: "This is a test email",
      seen: false,
    },
    {
      id: 2,
      subject: "Test email 2",
      email: "test2@example.com",
      message: "This is another test email",
      seen: true,
    },
  ];

  const deleteEmail = jest.fn();
  const toggleSeen = jest.fn();

  beforeEach(() => {
    render(
      <PermanentDrawerLeft
        emailData={emailData}
        deleteEmail={deleteEmail}
        toggleSeen={toggleSeen}
      />
    );
  });

  test("renders the app title", () => {
    const titleElement = screen.getByText(/AllState Email Application/i);
    expect(titleElement).toBeInTheDocument();
  });

  test("displays email subject and sender", () => {
    const subjectElement = screen.getByText(emailData[0].subject);
    const senderElement = screen.getByText(`From: ${emailData[0].email}`);
    expect(subjectElement).toBeInTheDocument();
    expect(senderElement).toBeInTheDocument();
  });

  test("calls toggleSeen when an email is clicked", () => {
    const emailElement = screen.getByText(emailData[0].subject);
    fireEvent.click(emailElement);
    expect(toggleSeen).toHaveBeenCalledWith(emailData[0]);
  });

  test("checks whether clicked email is opened", () => {
    const emailElement = screen.getByText(emailData[0].subject);
    fireEvent.click(emailElement);
    const subjectElement = screen.getByText("Subject: "+emailData[0].subject);
    expect(subjectElement).toBeInTheDocument();
  });

  test("filters emails by search field", () => {
    const searchInput = screen.getByPlaceholderText("From: Search here...");
    fireEvent.change(searchInput, { target: { value: emailData[0].email } });
    const filteredEmailElement = screen.getByText(emailData[0].subject);
    const unfilteredEmailElement = screen.queryByText(emailData[1].subject);
    expect(filteredEmailElement).toBeInTheDocument();
    expect(unfilteredEmailElement).not.toBeInTheDocument();
  });
});
