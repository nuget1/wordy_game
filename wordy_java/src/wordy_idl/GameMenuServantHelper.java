package wordy_idl;


/**
* wordy_idl/GameMenuServantHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Wednesday, May 10, 2023 8:56:36 o'clock PM SGT
*/


// Interface for the Game Menu Servant object
abstract public class GameMenuServantHelper
{
  private static String  _id = "IDL:wordy_idl/GameMenuServant:1.0";

  public static void insert (org.omg.CORBA.Any a, wordy_idl.GameMenuServant that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static wordy_idl.GameMenuServant extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (wordy_idl.GameMenuServantHelper.id (), "GameMenuServant");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static wordy_idl.GameMenuServant read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_GameMenuServantStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, wordy_idl.GameMenuServant value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static wordy_idl.GameMenuServant narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof wordy_idl.GameMenuServant)
      return (wordy_idl.GameMenuServant)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      wordy_idl._GameMenuServantStub stub = new wordy_idl._GameMenuServantStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static wordy_idl.GameMenuServant unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof wordy_idl.GameMenuServant)
      return (wordy_idl.GameMenuServant)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      wordy_idl._GameMenuServantStub stub = new wordy_idl._GameMenuServantStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
