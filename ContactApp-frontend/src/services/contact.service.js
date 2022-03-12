import axios from "axios";

const API_URL = "http://localhost:8082/api/test/contact/";
class ContactService{

contacts(username,name, phone,email) {
    return axios.post(API_URL + "add", {
      username,
      name,
      phone,
      email
      
    });
  }


getContacts(username) {
return axios.post(API_URL + "listing", {
  username
});
} 

}
  export default new ContactService();