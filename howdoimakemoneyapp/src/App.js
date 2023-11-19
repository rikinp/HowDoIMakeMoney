import React from "react";
import "./App.css";
import PermanentDrawerLeft from "./components/Emailinbox/EmailInbox.js";
import { useState, useEffect } from "react";
import axios from "axios";

function App() {
  const [emailData, setEmailData] = useState([]);

  const deleteEmail = (email) => {
    const requestOptions = {
      method: "DELETE",
    };
    fetch(`/email/delete/${email.id}`, requestOptions)
      .then((response) => {
        if (response.ok) {
          getData();
        }
      });
  };

  const toggleSeen = (clickedEmail) => {
    if(clickedEmail.seen === false) {
      clickedEmail.seen = true;
      const requestOptions = {
        method: "PUT",
        headers: { 
          "Accept": "application/json",
          "Content-Type": "application/json"
        },
        body: JSON.stringify(clickedEmail)
      };
      fetch(`/email/update`, requestOptions)
    }
  };

  const getData = async () => {
    const { data } = await axios.get(`/email/getAll`);
    setEmailData(data);
  };

  useEffect(() => {
    getData();
    // setEmailData(jsonData);
  }, []);
  const [bool, handleBool] = useState(true);

  return (
    <div className="App">
      <PermanentDrawerLeft
        emailData={emailData}
        deleteEmail={deleteEmail}
        toggleSeen={toggleSeen}
      />
      {bool && (
        <iframe
          allow="microphone;"
          width="650"
          height="430"
          src="https://console.dialogflow.com/api-client/demo/embedded/45803b78-932d-404b-8efa-5e13689225fe">
        </iframe>
      // onClick={() => console.log("Toggle bool")}
    )}
    </div>
  );
}
export default App;
