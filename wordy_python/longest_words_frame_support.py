#! /usr/bin/env python3
#  -*- coding: utf-8 -*-
#
# Support module generated by PAGE version 7.6
#  in conjunction with Tcl version 8.6
#    May 20, 2023 03:15:52 PM CST  platform: Windows NT

import sys
import tkinter as tk
import tkinter.ttk as ttk
from tkinter.constants import *

import longest_words_frame

_debug = True # False to eliminate debug printing from callback functions.

def main(game_menu_servant=None, *args):
    '''Main entry point for the application.'''
    global root
    root = tk.Tk()
    root.protocol( 'WM_DELETE_WINDOW' , root.destroy)
    # Creates a toplevel widget.
    global _top1, _w1
    _top1 = root
    _w1 = longest_words_frame.Toplevel1(_top1, game_menu_servant)
    root.mainloop()

if __name__ == '__main__':
    longest_words_frame.start_up()