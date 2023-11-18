import * as React from "react";
import Box from "@mui/material/Box";
import Drawer from "@mui/material/Drawer";
import CssBaseline from "@mui/material/CssBaseline";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import List from "@mui/material/List";
import Typography from "@mui/material/Typography";
import Divider from "@mui/material/Divider";
import ListItem from "@mui/material/ListItem";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import ListItemText from "@mui/material/ListItemText";
import ListItemAvatar from "@mui/material/ListItemAvatar";
import Avatar from "@mui/material/Avatar";
import InboxIcon from "@mui/icons-material/MoveToInbox";
import DeleteIcon from "@mui/icons-material/Delete";
import IconButton from "@mui/material/IconButton";
import { useState } from "react";
import { Badge } from "@material-ui/core";
import { Mail } from "@material-ui/icons";
import Email from "../E-mail/Email";
import SearchIcon from "@mui/icons-material/Search";
import "./SearchBar.css";

const drawerWidth = 400;

export default function PermanentDrawerLeft({ emailData, deleteEmail, toggleSeen }) {
  
  const [selectedEmail, setSelectedEmail] = useState(null);

  const handleEmailClick = (email) => {
    setSelectedEmail(email);
    toggleSeen(email);
  };

  const [searchField, setSearchField] = useState("");

  const filteredEmails = emailData.filter((email) => {
    return (
      email.email.toLowerCase().includes(searchField.toLowerCase())
    );
  });

  const handleChange = (e) => {
    setSearchField(e.target.value);
  };

  return (
    <Box sx={{ display: "flex" }}>
      <CssBaseline />
      <AppBar
        position="fixed"
        sx={{ width: `calc(100% - ${drawerWidth}px)`, ml: `${drawerWidth}px` }}
      >
        <Toolbar>
          <Typography variant="h6" noWrap component="div">
            How Do I Make Money
          </Typography>
        </Toolbar>
      </AppBar>
      <Drawer
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          "& .MuiDrawer-paper": {
            width: drawerWidth,
            boxSizing: "border-box",
          },
        }}
        variant="permanent"
        anchor="left"
      >
        <Toolbar>
          <div className="search">
            <div className="searchInputs">
              <input
                type="search"
                placeholder="From: Search here..."
                onChange={handleChange}
              />
              <div className="searchIcon">
                <SearchIcon />
              </div>
            </div>
          </div>
        </Toolbar>
        <Divider />
        <List>
          {filteredEmails.map((email) => (
            <ListItem key={email.id} alignItems="flex-start">
              <ListItemAvatar>
                <Badge variant="dot" color="primary" invisible={email.seen}>
                  
                  <Avatar>
                    <Mail />
                  </Avatar>
                </Badge>
              </ListItemAvatar>
              <ListItemButton
                onClick={() => handleEmailClick(email)}
                data-testid={`email-item-${email.id}`}
              >
                <div>
                  <ListItemText primary={email.subject} />
                  <ListItemText
                    primary={
                      <React.Fragment>
                        {" From: "}
                        {email.email}
                      </React.Fragment>
                    }
                    secondary={
                      <React.Fragment>
                        <Typography
                          sx={{ display: "inline" }}
                          component="span"
                          variant="body2"
                          color="text.primary"
                        >
                          {email.message}
                        </Typography>
                      </React.Fragment>
                    }
                  />
                </div>
              </ListItemButton>
              <IconButton aria-label="delete" onClick={() => deleteEmail(email)} data-testid={`delete-button-${email.id}`}>
                <DeleteIcon />
              </IconButton>
            </ListItem>
          ))}
        </List>
        <Divider />
        <List>
          {["All mail"].map((text, index) => (
            <ListItem key={text} disablePadding>
              <ListItemButton>
                <ListItemIcon>
                  <InboxIcon />
                </ListItemIcon>
                <ListItemText primary={text} />
              </ListItemButton>
            </ListItem>
          ))}
        </List>
      </Drawer>
      <Box
        component="main"
        sx={{ flexGrow: 1, bgcolor: "background.default", p: 1 }}
      >
        <Email selectedEmail={selectedEmail} />
      </Box>
    </Box>
  );
}