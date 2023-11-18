import React from "react";
import "./Email.css";
import Divider from "@mui/material/Divider";
import DeleteIcon from "@mui/icons-material/Delete";
import IconButton from "@mui/material/IconButton";

function Email({ selectedEmail }) {
  return (
    <div>
      {selectedEmail !== null && selectedEmail !== undefined ? (
        <div className="mail">
          <div className="mail-body">
            <div className="mail-bodyHeader">
              <div className="mail-subject">
                <h2>From: {selectedEmail.email}</h2>
              </div>
              <Divider />
              <div className="mail-subject">
                <h2>Subject: {selectedEmail.subject}</h2>
              </div>
              <Divider />
            </div>
            <div className="mail-message">
              <p>{selectedEmail.message}</p>
            </div>

          </div>
        </div>
      ) : (
        <p>No email selected.</p>
      )}
    </div>
  );
}

export default Email;
