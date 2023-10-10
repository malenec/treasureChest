translate([-42.25, 31.75, 54.0])
{
    difference()
    {
        linear_extrude(height = 11.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
        {
            scale([17.5, 9.5])
            {
                M8();
            }
        }
        translate([0.0, 0.0, 1.5])
        {
            linear_extrude(height = 9.5, twist = 0.0, scale = 1.0, slices = 1, center = false)
            {
                scale([14.5, 6.5])
                {
                    M8();
                }
            }
        }
        translate([8.0, 0.0, 0.0])
        {
            linear_extrude(height = 11.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
            {
                scale([1.5, 2.0])
                {
                    M8();
                }
            }
        }
    }
}

module M8()
{
    polygon
    (
        points =
        [
            [-0.5, -0.5], 
            [0.5, -0.5], 
            [0.5, 0.5], 
            [-0.5, 0.5]
        ],
        paths =
        [
            [0, 1, 2, 3]
        ]
    );
}
