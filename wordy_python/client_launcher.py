import sys
from omniORB import CORBA
import CosNaming

# Import the generated stubs
import wordy_idl, wordy_idl__POA
import os, sys

import login_frame_support


def main():

	hostName = sys.argv[1]
	port = sys.argv[2]

	# Initialize the ORB
	os.environ['ORBInitRef'] = f"NameService=corbaloc::{hostName}:{port}/NameService"
	orb = CORBA.ORB_init(sys.argv, CORBA.ORB_ID)

	# Obtain the Naming Service's root context
	obj = orb.resolve_initial_references("NameService")
	naming_context = obj._narrow(CosNaming.NamingContext)

	# Create a name to look up
	name = [CosNaming.NameComponent("Game Menu", "")]

	# Resolve the name to get the servant object reference
	obj = naming_context.resolve(name)
	gameMenuServant = obj._narrow(wordy_idl.GameMenuServant)

	login_frame_support.main(gameMenuServant, naming_context)


def print_usage():
	print('''
Usage:
	client_launcher.py [host_name] [port_number]

	Launches an instance of the Wordy game.

''')

if __name__ == '__main__':
	'''
	try:
		main()
	except:
		print_usage()
	'''
	main()


