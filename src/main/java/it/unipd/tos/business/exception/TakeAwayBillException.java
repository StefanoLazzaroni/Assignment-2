////////////////////////////////////////////////////////////////////
// [STEFANO] [LAZZARONI] [1170749]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Exception {
    public TakeAwayBillException(String messaggio) {
        super(messaggio);
    }
    public String getMessage() {
        return super.getMessage();
    }
}
