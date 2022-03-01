package customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import constants.MessageConstants;
import dao.CustomerDao;
import util.LogUtil;

/**
 * 顧客情報のロジック
 */
public class CustomerLogic {

    /**
     * DAO経由で顧客情報をDBから取得する
     * @param id 取得する顧客情報のID
     * @return 顧客情報Bean
     */
    public CustomerBean load(int id) {
        LogUtil.println(this.getClass().getSimpleName() + "#load");

        CustomerDao customerDao = new CustomerDao();
        CustomerBean customer = customerDao.load(id);

        return customer;
    }

    /**
     * DAO経由で顧客情報をDBに追加する
     * @param customer 顧客情報Bean
     * @return エラーメッセージ(処理成功時、null)
     */
    public String add(CustomerBean customer) {
        LogUtil.println(this.getClass().getSimpleName() + "#add");

        // TODO 実装 杉田 03/01
        CustomerDao customerDao = new CustomerDao();
       String result = customerDao.add(customer);

       if(result != null) {
           return MessageConstants.MESSAGE_CAN_NOT_ADD;
       }

        return null;
    }

    /**
     * DAO経由でDBの顧客情報を更新する
     * @param customer 顧客情報Bean
     * @return エラーメッセージ(処理成功時、null)
     */
    public String update(CustomerBean customer) {
        LogUtil.println(this.getClass().getSimpleName() + "#update");

        // TODO 実装 杉田 03/01
        CustomerDao customerDao = new CustomerDao();
        String result = customerDao.update(customer);

        if(result != null) {
            return MessageConstants.MESSAGE_CAN_NOT_UPDATE;
        }

        return null;
    }

    /**
     * DAO経由でDBの顧客情報を削除する
     * @param customer 顧客情報Bean
     * @return エラーメッセージ(処理成功時、null)
     */
    public String delete(CustomerBean customer) {
        LogUtil.println(this.getClass().getSimpleName() + "#delete");

        // TODO 実装 杉田 03/01
        CustomerDao customerDao = new CustomerDao();

        //間違ってるかも
        String result = customerDao.delete(customer.getId());

        if(result != null) {
            return MessageConstants.MESSAGE_CAN_NOT_DELETE;
        }

        return null;
    }

    /**
     * リクエスト内の顧客情報をセッションに顧客情報Beanとして設定する
     * @param request 顧客情報を含むリクエスト
     */
    public void setCustomerBeanFromRequestToSession(HttpServletRequest request) {
        LogUtil.println(this.getClass().getSimpleName() + "#setCustomerBeanFromRequestToSession");

        // TODO 実装 杉田 全く記述 違うかも
        request.setCharacterEncoding("UTF-8");
        CustomerBean customer = new CustomerBean();


        customer.setId(Integer.parseInt(request.getParameter("id")));
        customer.setName(request.getParameter("name"));
        customer.setZip(request.getParameter("Zip"));
        customer.setAddress1(request.getParameter("address1"));
        customer.setAddress2(request.getParameter("address2"));
        customer.setEmail(request.getParameter("email"));
        customer.setTel(request.getParameter("tel"));
        customer.setFax(request.getParameter("fax"));

        HttpSession session = request.getSession();
        session.setAttribute("customer", customer);
        }
    }
