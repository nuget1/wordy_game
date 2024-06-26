package wordy_idl;


/**
* wordy_idl/_GameMenuServantStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from wordy.idl
* Wednesday, May 10, 2023 8:56:36 o'clock PM SGT
*/


// Interface for the Game Menu Servant object
public class _GameMenuServantStub extends org.omg.CORBA.portable.ObjectImpl implements wordy_idl.GameMenuServant
{

  public void gameStarted ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("gameStarted", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                gameStarted (        );
            } finally {
                _releaseReply ($in);
            }
  } // gameStarted

  public void playersUpdated (int[] players)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("playersUpdated", true);
                wordy_idl.playerHelper.write ($out, players);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                playersUpdated (players        );
            } finally {
                _releaseReply ($in);
            }
  } // playersUpdated

  public int logIn (String username, String password) throws wordy_idl.InvalidPasswordException, wordy_idl.NoUserFoundException, wordy_idl.LoggedInException, wordy_idl.IncompleteCredentialsException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("logIn", true);
                $out.write_string (username);
                $out.write_string (password);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:wordy_idl/InvalidPasswordException:1.0"))
                    throw wordy_idl.InvalidPasswordExceptionHelper.read ($in);
                else if (_id.equals ("IDL:wordy_idl/NoUserFoundException:1.0"))
                    throw wordy_idl.NoUserFoundExceptionHelper.read ($in);
                else if (_id.equals ("IDL:wordy_idl/LoggedInException:1.0"))
                    throw wordy_idl.LoggedInExceptionHelper.read ($in);
                else if (_id.equals ("IDL:wordy_idl/IncompleteCredentialsException:1.0"))
                    throw wordy_idl.IncompleteCredentialsExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return logIn (username, password        );
            } finally {
                _releaseReply ($in);
            }
  } // logIn

  public void startGame () throws wordy_idl.NoPlayersJoinedException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("startGame", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:wordy_idl/NoPlayersJoinedException:1.0"))
                    throw wordy_idl.NoPlayersJoinedExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                startGame (        );
            } finally {
                _releaseReply ($in);
            }
  } // startGame

  public String[] getBestPlayers ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getBestPlayers", true);
                $in = _invoke ($out);
                String $result[] = wordy_idl.bestPlayersHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getBestPlayers (        );
            } finally {
                _releaseReply ($in);
            }
  } // getBestPlayers

  public String[] getLongestWords ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getLongestWords", true);
                $in = _invoke ($out);
                String $result[] = wordy_idl.longestWordsHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getLongestWords (        );
            } finally {
                _releaseReply ($in);
            }
  } // getLongestWords

  public void logOut (String username)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("logOut", true);
                $out.write_string (username);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                logOut (username        );
            } finally {
                _releaseReply ($in);
            }
  } // logOut

  public int updateCountdown (int value)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("updateCountdown", true);
                $out.write_long (value);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return updateCountdown (value        );
            } finally {
                _releaseReply ($in);
            }
  } // updateCountdown

  public int inQueue ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("inQueue", true);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return inQueue (        );
            } finally {
                _releaseReply ($in);
            }
  } // inQueue

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:wordy_idl/GameMenuServant:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _GameMenuServantStub
