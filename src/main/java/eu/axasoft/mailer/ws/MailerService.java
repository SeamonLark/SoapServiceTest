package eu.axasoft.mailer.ws;

import eu.axasoft.soapsettest.core.ApplicationBean;
import eu.axasoft.soapsettest.core.EjbTestLocal;
import java.util.Date;
import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.ws.WebServiceContext;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author balaz
 */
@WebService(serviceName = "MailerService")
@Stateless
public class MailerService {

    private static final Logger LOG = Logger.getLogger(MailerService.class.getName());
    
    @Resource
    private WebServiceContext context;
    
    @Inject
    private ApplicationBean appBean;
    @EJB
    private EjbTestLocal ejbTest;

    /**
     * Stores the plain or html email into the database. 
     * 
     * @param destinationAddress destination address or addresses separated by comma
     * @param sourceAddress sender of the email
     * @param subject subject of the email
     * @param content plain text or html content
     * @param htmlContent differs if the content is html content or plain text
     * @return if the operation succeeds email id is returned. Otherwise exception is thrown.
     * @throws MailerServiceException Wraps catched excepions.
     * @throws InterruptedException - actually not thrown but still remains in siganture because of backward compatibility.
     */
    @WebMethod(operationName = "storeEmail")

    public Integer storeEmail(        
        @WebParam(name = "destinationAddress") String destinationAddress,
        @XmlElement(required = false) @WebParam(name = "sourceAddress") String sourceAddress, 
        @XmlElement(required = false) @WebParam(name="subject") String subject,
        @WebParam(name="content") String content,
        @WebParam(name="htmlContent") boolean htmlContent
    ) throws InterruptedException {
        LOG.log(Level.FINE, "Values passed from caller: destinationAdddress: {0} sourceAddress: {1}, subject: {2}, content: {3}",
            new Object[] {destinationAddress, sourceAddress, subject, content});
        LOG.log(Level.FINE,"Service called at: {0}", new Date());
        long startTime = System.currentTimeMillis();
        LOG.log(Level.INFO,"Appbean: {0}", appBean);
        LOG.log(Level.INFO,"EjbTest: {0}", ejbTest);
        int nullCount = 0;
        if (appBean == null) {
            nullCount++;
        }
        if (appBean == null) {
            nullCount++;
        }
        
        return nullCount;
    }
    
    /**
     * Returns the email status. 
     * @param emailId email database id
     * @return String describing email status {NEW, INPC, ERR, SENT}
     */
    @WebMethod(operationName = "getEmailStatus")

    public String getEmailStatus(@WebParam(name = "emailId") Integer emailId) {
        return "";
    }
    
    /**
     * actually do nothing!  
     */
    @WebMethod(operationName = "sendError" )

    public void sendError( @WebParam( name = "emailAddress" ) String emailAddress ){
        
    }

    /**
     * Stores the plain or html email into the database. This version supports 
     * also attachments, which are separated by semicolon (;)
     * 
     * @param destinationAddress destination address or addresses separated by comma
     * @param sourceAddress sender of the email
     * @param subject subject of the email
     * @param content plain text or html content
     * @param htmlContent differs if the content is html content or plain text
     * @param pathToAttachments optional parateter which contais the semicolon separated paths 
     * to the email attachments. Attachment must exist in the time of calling this service.
     * @return if the operation succeeds email id is returned. Otherwise exception is thrown.
     * @throws MailerServiceException Wraps catched excepions.
     */
    @WebMethod(operationName = "storeEmailWithAttachment")

    public Integer storeEmailWithAttachment(
        @WebParam(name = "destinationAddress") String destinationAddress, 
        @XmlElement(required = false) @WebParam(name = "sourceAddress") String sourceAddress, 
        @XmlElement(required = false) @WebParam(name = "subject") String subject, 
        @WebParam(name = "content") String content, 
        @WebParam(name = "htmlContent") boolean htmlContent, 
        @XmlElement(required = false) @WebParam(name = "pathToAttachments") String pathToAttachments) 
    {
        LOG.log(Level.FINE, "Values passed from caller: destinationAdddress: {0} sourceAddress: {1}, subject: {2}, content: {3}, html content: {4}, attachment path: {5}",
            new Object[] {destinationAddress, sourceAddress, subject, content, htmlContent, pathToAttachments});
        LOG.log(Level.FINE, "Service called at: {0}", new Date() );

        return 0;
    }
    
}
