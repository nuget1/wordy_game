package wordy_idl;


/**
* wordy_idl/InvalidWordException.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Wednesday, May 10, 2023 8:56:36 o'clock PM SGT
*/

public final class InvalidWordException extends org.omg.CORBA.UserException
{

  public InvalidWordException ()
  {
    super(InvalidWordExceptionHelper.id());
  } // ctor


  public InvalidWordException (String $reason)
  {
    super(InvalidWordExceptionHelper.id() + "  " + $reason);
  } // ctor

} // class InvalidWordException
