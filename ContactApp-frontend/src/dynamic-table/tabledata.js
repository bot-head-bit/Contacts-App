import contactService from "../services/contact.service";
import AuthService from "../services/auth.service";


async function getTableData() {
var TableDataMaster = await contactService.getContacts(AuthService.getCurrentUser().username);

const TableData=TableDataMaster.data.data.contactDetailsList1;

return TableData;
}
export default getTableData;
