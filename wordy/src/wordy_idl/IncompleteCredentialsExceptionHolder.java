package wordy_idl;

/**
* wordy_idl/IncompleteCredentialsExceptionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Wednesday, May 10, 2023 8:56:36 o'clock PM SGT
*/

public final class IncompleteCredentialsExceptionHolder implements org.omg.CORBA.portable.Streamable
{
  public wordy_idl.IncompleteCredentialsException value = null;

  public IncompleteCredentialsExceptionHolder ()
  {
  }

  public IncompleteCredentialsExceptionHolder (wordy_idl.IncompleteCredentialsException initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = wordy_idl.IncompleteCredentialsExceptionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    wordy_idl.IncompleteCredentialsExceptionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return wordy_idl.IncompleteCredentialsExceptionHelper.type ();
  }

}
