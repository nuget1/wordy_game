package wordy_idl;

/**
* wordy_idl/GameServantHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Wednesday, May 10, 2023 8:56:36 o'clock PM SGT
*/


// Interface for a Game object when a player joins a game
public final class GameServantHolder implements org.omg.CORBA.portable.Streamable
{
  public wordy_idl.GameServant value = null;

  public GameServantHolder ()
  {
  }

  public GameServantHolder (wordy_idl.GameServant initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = wordy_idl.GameServantHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    wordy_idl.GameServantHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return wordy_idl.GameServantHelper.type ();
  }

}