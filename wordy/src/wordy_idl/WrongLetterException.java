package wordy_idl;


/**
* wordy_idl/WrongLetterException.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Wednesday, May 10, 2023 8:56:36 o'clock PM SGT
*/

public final class WrongLetterException extends org.omg.CORBA.UserException
{

  public WrongLetterException ()
  {
    super(WrongLetterExceptionHelper.id());
  } // ctor


  public WrongLetterException (String $reason)
  {
    super(WrongLetterExceptionHelper.id() + "  " + $reason);
  } // ctor

} // class WrongLetterException
