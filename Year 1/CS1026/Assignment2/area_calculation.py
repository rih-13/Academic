#CS1026 Assignment 2
#Contains functions that take in relevent dimensions of a shape and returns its area. It can
#calculates trapezoids, rectangles, and ellipses


import math #needed for accurate pi calculation

def ellipse_area(major, minor):
    """ellipse_area: function takes major and minor radius of ellipse and returns area
    Parameters: major, minor
    Return Value: area of ellipse with parameters"""
    area = major * minor * math.pi
    return(area)

def rectangle_area(base, height):
    """rectangle_area: function takes base and height of rectangle and returns area
    Parameters: base, height
    Return Value: area of rectangle with parameters"""
    area = base * height
    return(area)

def trapezoid_area(top, bottom, height):
    """trapezoid_area: function takes length of top side, length of bottom side, and height of trapezoid and returns area
    Parameters: top, bottom, height
    Return Value: area of traoeziud with parameters"""
    area = 0.5 * height * (top + bottom)
    return(area)
