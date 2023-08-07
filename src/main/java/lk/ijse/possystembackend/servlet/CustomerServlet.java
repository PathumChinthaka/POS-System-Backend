package lk.ijse.possystembackend.servlet;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.ijse.possystembackend.dto.CustomerDTO;
import lk.ijse.possystembackend.service.ServiceFactory;
import lk.ijse.possystembackend.service.custom.CustomerService;
import lk.ijse.possystembackend.service.utill.ServiceTypes;
import org.eclipse.yasson.internal.JsonBinding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService;
    private Jsonb jsonb;

    @Override
    public void init() throws ServletException {
        customerService= ServiceFactory.getInstance().getService(ServiceTypes.CUSTOMER_SERVICE);
        jsonb= JsonbBuilder.create();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST Req Awa");
        if(req.getContentType()==null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }else {
            try {
                CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);
                validate(customerDTO);
                boolean save=customerService.saveData(customerDTO);
                if (save){
                    resp.setStatus(HttpServletResponse.SC_ACCEPTED);
                }else {
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST,e.getMessage());
            }
        }
    }

    private void validate(CustomerDTO customerDTO) throws RuntimeException {
        System.out.println(customerDTO);
        if (customerDTO.getCusId() == null || !customerDTO.getCusId().matches("^C(00[1-9]|0[1-9]\\d|[1-9]\\d{2})$")) {
            throw new RuntimeException("Invalid customer id!");
        } else if (customerDTO.getCusName() == null || !customerDTO.getCusName().matches("^[A-Za-z]+(?:\\s[A-Za-z]+)*$")) {
            throw new RuntimeException("Invalid customer name!");
        } else if (customerDTO.getAddress() == null || !customerDTO.getAddress().matches("^[A-Za-z]+(?:\\s[A-Za-z]+)*$")) {
            throw new RuntimeException("Invalid customer city!");
        } else{
            System.out.println("validate Else");
        }
    }
}
